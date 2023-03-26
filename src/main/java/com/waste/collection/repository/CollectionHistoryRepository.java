package com.waste.collection.repository;

import com.waste.collection.domain.CollectionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionHistoryRepository extends JpaRepository<CollectionHistory, Long> {}
