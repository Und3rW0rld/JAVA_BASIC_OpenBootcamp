package Clases;

import com.Interfaces.underworld.CocheCRUD;

public class CocheCRUDImpl implements CocheCRUD {
    @Override
    public void save() {
        System.out.println("Using Save Method...");
    }

    @Override
    public void findAll() {
        System.out.println("Using Find All Method...");
    }

    @Override
    public void delete() {
        System.out.println("Using Delete Method...");
    }
}
