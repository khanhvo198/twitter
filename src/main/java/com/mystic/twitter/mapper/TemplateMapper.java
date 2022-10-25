package com.mystic.twitter.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TemplateMapper {
  private final ModelMapper modelMapper;

  public <T, S> S convertToEntity(T data, Class<S> type) {
    return modelMapper.map(data, type);
  }
}
