package com.template.web.common.domain.repository;

import com.template.web.common.domain.entity.Config;
import com.template.web.common.domain.entity.ConfigIds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, ConfigIds> {

    Optional<Config> findByConfigIds(ConfigIds configIds);

}
