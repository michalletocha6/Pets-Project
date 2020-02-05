package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.Type;
import letocha.michal.petsProject.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Integer id) {
        return typeRepository.findById(id).get();
    }

}
