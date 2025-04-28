package com.simplilearn.zumbamanagement.dao;

import com.simplilearn.zumbamanagement.DB.DBConnection;
import com.simplilearn.zumbamanagement.model.Batch;
import com.simplilearn.zumbamanagement.model.Participant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDaoImpl implements Dao<Participant> {
    private final Connection dbConnection = DBConnection.getInstance().getConnection();
    private final Logger LOGGER = Logger.getLogger(ParticipantDaoImpl.class);

    @Override
    public List<Participant> getAll() {
        String sql = "SELECT * FROM participant";
        List<Participant> participants = new ArrayList<>();
        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String batchId= rs.getString(5);
                Participant participant = new Participant(id, name, email, phone, batchId);
                participants.add(participant);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return participants;
    }

    @Override
    public int save(Participant participant) {
        String query = "INSERT INTO participant VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, participant.getName());
            preparedStatement.setString(3, participant.getEmail());
            preparedStatement.setString(4, participant.getPhone());
            preparedStatement.setString(5, participant.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return 0;
    }

    @Override
    public void delete(List<Participant> participants) {
        String query = "DELETE FROM participant WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            for (Participant participant : participants) {
                preparedStatement.setString(1, participant.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
