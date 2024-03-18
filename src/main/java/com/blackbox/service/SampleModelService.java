package com.blackbox.service;

import com.blackbox.mappers.SampleModelMapper;
import com.blackbox.model.SampleModel;
import com.blackbox.utils.DBUtils;

import java.util.List;
import java.util.Map;

public class SampleModelService {
    public List<SampleModel> getAllSampleModels() {
        String query = "SELECT * FROM sample";
        return DBUtils.executeQuery(query, new SampleModelMapper());
    }

    public SampleModel getSampleById(int sampleId) {
        String query = "SELECT * FROM sample WHERE sample_id=" + sampleId;
        List<SampleModel> actors = DBUtils.executeQuery(query, new SampleModelMapper());
        return actors.isEmpty() ? null : actors.get(0);
    }

    public Map<String, Object> getSampleNameAndLastNameById(int sampleId) {
        String query = "SELECT first_name, last_name FROM sample WHERE sample_id=" + sampleId;
        return DBUtils.executeQueryForMapList(query).get(0);
    }
}
