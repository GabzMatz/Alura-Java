package org.estudo.aluraSpring001.service;

public interface IConverDados {
    <T> T obterDados(String json, Class<T> classe);
}