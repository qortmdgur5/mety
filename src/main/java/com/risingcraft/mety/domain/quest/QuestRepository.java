package com.risingcraft.mety.domain.quest;

import com.risingcraft.mety.domain.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Integer> {
}
