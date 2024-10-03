package org.alura.table_fipe.model;


import com.google.gson.annotations.SerializedName;

public record Template(@SerializedName("codigo") String cod,
                       @SerializedName("nome") String descricao) {
}
