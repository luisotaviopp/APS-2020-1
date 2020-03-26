package br.com.ies;

import br.com.ies.builder.QueryBuilder;
import br.com.ies.dto.ColunaValorDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.entity.ArtistaEntity;

public class Main {

	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ArtistaEntity artistaEntity = new ArtistaEntity();
		
		artistaEntity.setArtCodigo(1);
		artistaEntity.setArtNome("Paulinho");
		artistaEntity.setArtDescricao("Vencedor");
		
		QueryBuilder queryBuilder = new QueryBuilder(artistaEntity);
		QueryDTO queryDto = queryBuilder.construir();
		
		System.out.println(queryDto.getSchema());
		System.out.println(queryDto.getTabela());

		for(ColunaValorDTO cv : queryDto.getColunaValor()) {
			System.out.println("-------------------------------------------");
			System.out.println(cv.getColuna() + "|| " + cv.getValor());
			System.out.println("-------------------------------------------");
		}

	}
}
