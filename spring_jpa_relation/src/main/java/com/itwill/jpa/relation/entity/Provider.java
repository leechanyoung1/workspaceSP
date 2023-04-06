package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name="Provider")

public class Provider extends BaseEntity{
	@Id
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "provider")
	List<Product> productList = new ArrayList<>();
}
