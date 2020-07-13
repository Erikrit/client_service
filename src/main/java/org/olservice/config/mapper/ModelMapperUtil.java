package org.olservice.config.mapper;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil extends ModelMapper {
    public ModelMapperUtil(){
            this.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        }
}
