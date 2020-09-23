package pl.arturzaczek.api_demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arturzaczek.api_demo.entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
