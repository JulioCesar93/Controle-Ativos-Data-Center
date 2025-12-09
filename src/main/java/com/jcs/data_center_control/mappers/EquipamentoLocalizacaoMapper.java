package com.jcs.data_center_control.mappers;

import com.jcs.data_center_control.DTO.EquipamentoLocalizacaoDTO;
import com.jcs.data_center_control.entity.Equipamento;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EquipamentoLocalizacaoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "clienteNome", target = "clienteNome")
    @Mapping(source = "hostname", target = "hostname")
    @Mapping(source = "serialTag", target = "serialTag")
    @Mapping(source = "ipProducao", target = "ipProducao")
    @Mapping(source = "ipIdrac", target = "ipIdrac")
    @Mapping(source = "patrimonio", target = "patrimonio")
    @Mapping(source = "processador", target = "processador")
    @Mapping(source = "memoria", target = "memoria")
    @Mapping(source = "hd", target = "hd")
    @Mapping(source = "nucleos", target = "nucleos")
    @Mapping(source = "tipoServico", target = "tipoServico")
    @Mapping(source = "statusEquipamento", target = "statusEquipamento")
    @Mapping(source = "fornecedorGarantia", target = "fornecedorGarantia")
    @Mapping(source = "observacoes", target = "observacoes")

    @Mapping(target = "dataAtivacao",
            expression = "java(e.getDataAtivacao() != null ? e.getDataAtivacao().toString() : null)")
    @Mapping(target = "dataInicioGarantia",
            expression = "java(e.getDataInicioGarantia() != null ? e.getDataInicioGarantia().toString() : null)")
    @Mapping(target = "dataFimGarantia",
            expression = "java(e.getDataFimGarantia() != null ? e.getDataFimGarantia().toString() : null)")

    @Mapping(source = "localizacao.ordemLoc", target = "ordemLoc")
    @Mapping(source = "localizacao.dataCenter", target = "dataCenter")
    @Mapping(source = "localizacao.local", target = "local")
    @Mapping(source = "localizacao.sala", target = "sala")
    @Mapping(source = "localizacao.fila", target = "fila")
    @Mapping(source = "localizacao.bastidor", target = "bastidor")
    @Mapping(source = "localizacao.nivel", target = "nivel")
    @Mapping(source = "localizacao.statusLocal", target = "statusLocal")

    EquipamentoLocalizacaoDTO toDTO(Equipamento e);
}
