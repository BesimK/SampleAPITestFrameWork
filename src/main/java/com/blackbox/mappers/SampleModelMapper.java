package com.blackbox.mappers;

import com.blackbox.model.SampleModel;
import com.blackbox.utils.RowMapper;

import java.sql.ResultSet;

public class SampleModelMapper implements RowMapper<SampleModel> {
    @Override
    public SampleModel mapRow(ResultSet rs) throws Exception {
        return new SampleModel(rs.getString("first"),rs.getString("second"));
    }
}
