package com.optimagrowth.organization.service;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.respository.OrganizationRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {

  private final OrganizationRepository repository;

  public OrganizationService(OrganizationRepository repository) {
    this.repository = repository;
  }

  public Organization findById(String organizationId) {
    Optional<Organization> organization = repository.findById(organizationId);
    return organization.orElse(null);
  }

  public Organization create(Organization organization) {
    organization.setId(UUID.randomUUID().toString());
    organization = repository.save(organization);
    return organization;
  }

  public void update(Organization organization) {
    repository.save(organization);
  }

  public void delete(String organizationId) {
    repository.deleteById(organizationId);
  }

}
