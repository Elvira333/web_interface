package org.openapitools.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;


import javax.annotation.Generated;

/**
 * Student
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-19T12:57:30.274029200+03:00[Europe/Moscow]")
public class Student {
  private Long id;
  private String login;

  private String name;

  private String surname;

  private Integer age;

  private Set<Subject> subjects;

  /**
   * Constructor with only required parameters
   */
  public Student(String login, String name, String surname, Integer age, Set<Subject> subjects) {
    this.login = login;
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.subjects = subjects;
  }

  public Student id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  */
  @NotNull 
  @Schema(name = "login", example = "Ivan123", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Student name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull 
  @Schema(name = "name", example = "Ivan", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String firstName) {
    this.name = name;
  }


  public Student surName(String surName) {
    this.surname = surName;
    return this;
  }

  /**
   * Get surName
   * @return surName
  */
  
  @Schema(name = "surName", example = "Ivanov", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surName")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String lastName) {
    this.surname = surname;
  }

  public Student age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  */
  @NotNull 
  @Schema(name = "age", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.login, student.login) &&
        Objects.equals(this.name, student.name) &&
        Objects.equals(this.surname, student.surname) &&
        Objects.equals(this.age, student.age) &&
        Objects.equals(this.subjects,student.subjects);
  }
 public Student subjects() {
    this.subjects=subjects;
    return this;
 }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, name, surname, age,subjects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

