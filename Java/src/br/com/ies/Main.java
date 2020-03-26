package br.com.ies;

import br.com.ies.builder.QueryBuilder;
import br.com.ies.dto.ColunaValorDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.entity.VendaEntity;
import br.com.ies.entity.VendaIngressoEntity;

public class Main {

	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		VendaIngressoEntity vendaIngressoEntity = new VendaIngressoEntity();
		
		vendaIngressoEntity.setVeiCodigo(12);
		vendaIngressoEntity.setVeiDocumento("24p24");
		vendaIngressoEntity.setVeiNome("Teu pai");
		vendaIngressoEntity.setVeiUtilizado(false);
		
		VendaEntity vendaEntity = new VendaEntity();
		vendaEntity.setVenCodigo(1);
		
		vendaIngressoEntity.setVendaEntity(vendaEntity);
		
		QueryBuilder queryBuilder = new QueryBuilder(vendaIngressoEntity);
		QueryDTO queryDTO = queryBuilder.build();
		
		for(ColunaValorDTO cv : queryDTO.getColunaValor()) {
			System.out.println(cv.getColuna() + ":" + cv.getValor());
		}
	}
}
