package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.models.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> listTag() throws Exception;
    Tag getTag(Tag tag) throws Exception;
}
