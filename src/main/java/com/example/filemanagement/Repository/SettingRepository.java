package com.example.filemanagement.Repository;

import com.example.filemanagement.Model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Integer> {
    Setting findTopByOrderByIdDesc();
}
