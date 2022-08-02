package com.risingcraft.mety.service.data;

import com.risingcraft.mety.domain.data.Data;
import com.risingcraft.mety.domain.data.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DataService {

    private final DataRepository dataRepository;

    public List<Data> 마이기록(int id) {
        List<Data> data = dataRepository.findAllByUserId(id);
        return data;
    }
}
