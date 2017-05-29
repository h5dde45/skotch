package ru.project.dao.interfaces;

import ru.project.entities.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getGenres();
}
