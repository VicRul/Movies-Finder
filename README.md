# Movies-Finder
## Описание
Тестовое задание - GraphQL API на основе The Movie Database REST API. Разработано с использованием:
* SpringBoot
* Spring Data JPA
* H2 database
* Retrofit
* GraphQL-SPQR
* Lombok
## Установка и развертывание
Приложение можно скомпилировать в исполняемый JAR файл с помощью команды Maven:
`mvn clean package`.</br>
Команда должна быть запущена из корневой директории приложения. Скомпилированый файл лежит в папке `target/moviesfinder-1.0.jar`.
</br>
Для запуска приложения используйте команду `java -jar moviesfinder-1.0.jar`. Приложение будет доступно по адресу: `http://localhost:9000/`.
## Примеры запросов
Поддерживаются следующие типы запросов:
* Получение списка популярных фильмов (постранично)
```graphql
    query {
    listPopularMovies(page: 159) {
      page,
      totalPages,
      totalResults,
      moviesList {
        id,
        title,
        releaseDate,
        overview,
        genres {
          name
        }
      }
    }
  }
```
* Получение детальной информации по отдельным фильмам (по идентификатору фильма)
```graphql
    query {
      movieById(id:234) {
        id,
        title,
        releaseDate,
        overview,
        genres {
          name
        },
        homePage,
        runtime,
        spokenLanguages {
          name
        },
        productionCompanies {
          name
        },
        productionCountries {
          name
        },
        popularity,
        voteAverage,
        voteCount
      }
    }
```
* Поиск фильмов по названию (постранично)
```graphql
    uery {
      listMoviesByName(title: "Мстители", page: 1){
        page,
        totalPages,
        totalResults,
        moviesList {
          id,
          title,
          releaseDate,
          overview,
          genres {
            name
          }
        }
      }
    }
```
* Добавление фильма в избранное (по идентификатору пользователя)
```graphql
    mutation {
      addToFavoriteMoviesList(userId: 2, movieId: 243){
        id,
        title,
        releaseDate,
        overview,
        genres {
          name
        },
        homePage,
        runtime,
        spokenLanguages {
          name
        },
        productionCompanies {
          name
        },
        productionCountries {
          name
        },
        popularity,
        voteAverage,
        voteCount
      }
    }
```
* Удаление фильма из избранного (по идентификатору пользователя)
```graphql
    mutation {
      deleteFromFavoriteMovieList(userId: 2, movieId: 242){
          id,
            title,
            releaseDate,
            overview,
            genres {
              name
            },
            homePage,
            runtime,
            spokenLanguages {
              name
            },
            productionCompanies {
              name
            },
            productionCountries {
              name
            },
            popularity,
            voteAverage,
            voteCount
      }
  }
```
* Получение списка избранных фильмов (постранично, по идентификатору пользователя)
```graphql
    query {
      listFavoriteMovies(userId: 1, page: 1) {
        page,
        totalPages,
        totalResult,
        favoriteMovies {
          id,
          title,
          releaseDate,
          overview,
          genres {
            name
          }
        } 
      }
    }
```
