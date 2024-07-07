package br.com.aishac.studying.domains.repositories.entities;

import lombok.Builder;

@Builder
public record ContactEntity (String name, String email) {}
