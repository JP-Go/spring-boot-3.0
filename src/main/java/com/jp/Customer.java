package com.jp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Customer {

  @Id
  @SequenceGenerator(name = "customer_id_sequence",
                     sequenceName = "customer_id_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
                  generator = "customer_id_sequence")
  private Integer id;
  private String name;
  private String email;
  private Integer age;

  public Customer(Integer id, String name, String email, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public Customer() {}

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  public Integer getAge() { return age; }

  public void setAge(Integer age) { this.age = age; }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((age == null) ? 0 : age.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Customer other = (Customer)obj;
    return Objects.equals(id, other.id) && Objects.equals(name, other.name) &&
        Objects.equals(email, other.email) && Objects.equals(age, other.age);
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", email=" + email +
        ", age=" + age + "]";
  }
}
