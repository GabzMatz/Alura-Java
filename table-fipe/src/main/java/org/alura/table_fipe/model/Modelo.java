package org.alura.table_fipe.model;


import com.google.gson.annotations.SerializedName;

public record Modelo(@SerializedName("codigo") String cod,
                     @SerializedName("nome") String descricao) {
}
