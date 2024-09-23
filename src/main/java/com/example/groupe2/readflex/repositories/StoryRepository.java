package com.example.groupe2.readflex.repositories;

import com.example.groupe2.readflex.models.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
