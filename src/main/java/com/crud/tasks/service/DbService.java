package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return (List<Task>) repository.findAll();
    }
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }
    public boolean deleteTaskById(Long taskId) {
        if (repository.existsById(taskId)) {
            repository.deleteById(taskId);
            return true;
        }
        return false;
    }

}


//    Moja aplikacja to system do zarządzania zadaniami (taskami) o nazwie "Task CRUD". Korzysta
//    z bazy danych MySQL do przechowywania informacji o zadaniach. Wykorzystuje framework Spring Boot
//    wraz z modułem Spring Data JPA do obsługi operacji na bazie danych, co pozwala na wygodne
//zarządzanie encjami i relacjami w modelu obiektowym. Ponadto, aplikacja korzysta z bibliotek takich jak:
//        Spring Boot Starter Web - do obsługi warstwy HTTP, umożliwiającej komunikację z aplikacją
//        poprzez protokół HTTP.
//        Spring Boot Starter Data JPA - do integracji z bazą danych poprzez technologię
//        JPA (Java Persistence API), co ułatwia wykonywanie operacji CRUD na encjach.
//        Lombok - biblioteka ułatwiająca tworzenie klas poprzez automatyczne generowanie
//        metod getter, setter i toString, co eliminuje konieczność pisania rutynowego kodu.
//        MySQL Connector Java - sterownik JDBC dla bazy danych MySQL, umożliwiający komunikację między
//        aplikacją a bazą danych MySQL.
//
//        Co do obsługi żądań HTTP, aplikacja korzysta z następujących metod:
//
//        GET - do pobierania zadań z bazy danych oraz pojedynczego zadania na podstawie jego
//        identyfikatora.
//        DELETE - do usuwania zadań z bazy danych na podstawie ich identyfikatorów.