# Spring Boot MongoDB GraphQL Tutorial
___

## GitHub Repository 

[Spring Boot MongoDB GraphQL]

___

### PREREQUISITES FOR RUNNING APPLICATION

1-run mongo db on default port (27017)

2-set your profile to test.

3-run the application from GraphQLApplication.

### GraphQL sample queries

Singers Query
```shell script
{
  singers{
    id
    name
    age
    gender
    thumbnail
    musics {
      genre
      instrument
    }
  }
}
````
```shell script
{
  getSingers(singerId:"62e761f3c2966a324f433a4d"){
    id
    name
    age
    gender
    thumbnail
    musics {
      genre
      instrument
    }
  }
}
````
Musics Query
```shell script
{
  getSingerMusics(singerId:"62e761f3c2966a324f433a4d"){
    genre
    instrument
    chord
  
  }
}
````

Mutation
```shell script
mutation{
  singerPersistence(name:"tyga",age:24,gender:"male"){
    id
    name
    age
    gender
  }
}
```