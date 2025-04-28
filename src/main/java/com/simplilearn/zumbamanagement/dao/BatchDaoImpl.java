package com.simplilearn.zumbamanagement.dao;

import com.simplilearn.zumbamanagement.DB.DBConnection;
import com.simplilearn.zumbamanagement.model.Batch;
import com.simplilearn.zumbamanagement.services.BatchService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDaoImpl implements Dao<Batch> {
    private final Connection dbConnection = DBConnection.getInstance().getConnection();
    private final Logger LOGGER = Logger.getLogger(BatchService.class);

    @Override
    public List<Batch> getAll() {
        String sql = "SELECT * FROM batch";
        List<Batch> batches = new ArrayList<>();
        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                String session = rs.getString(2);
                Batch batch = new Batch(id, session);
                batches.add(batch);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
        return batches;
    }

    @Override
    public int save(Batch batch) {
        String query = "INSERT INTO batch VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, null);
            LOGGER.info("Inserting batch: " + batch.getSession());
            preparedStatement.setString(2, batch.getSession());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return 0;
    }

    @Override
    public void delete(List<Batch> batches) {
        String query = "DELETE FROM batch WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            for (Batch batch : batches) {
                preparedStatement.setInt(1, batch.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
