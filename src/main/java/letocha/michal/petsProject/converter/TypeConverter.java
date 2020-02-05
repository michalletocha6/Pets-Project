package letocha.michal.petsProject.converter;

import letocha.michal.petsProject.entity.Type;
import letocha.michal.petsProject.service.TypeService;
import org.springframework.core.convert.converter.Converter;

public class TypeConverter implements Converter<String, Type> {
    private final TypeService typeService;

    public TypeConverter(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type convert(String source) {
        return typeService.getTypeById(Integer.valueOf(source));
    }

}
