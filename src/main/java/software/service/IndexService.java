package software.service;

import software.jsonModel.IndexObject;

import java.util.List;

public interface IndexService {
  List<IndexObject> getIndexContent();
}
