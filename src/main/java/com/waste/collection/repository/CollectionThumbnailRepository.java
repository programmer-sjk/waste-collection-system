package com.waste.collection.repository;

import com.waste.collection.domain.CollectionThumbnail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionThumbnailRepository extends JpaRepository<CollectionThumbnail, Long> {}
