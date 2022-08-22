package org.cmp.k8s.service;

import org.cmp.k8s.model.dto.PodDTO;

import java.util.List;

public interface PodService {

    List<PodDTO> list(String namespace);
}
