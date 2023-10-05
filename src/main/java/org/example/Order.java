package org.example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String nama;
    private Integer kuantitas;
    private Integer totalHarga; 

}



