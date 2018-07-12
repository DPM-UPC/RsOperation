package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.domains.Category;
import pe.edu.upc.RsOperation.domains.Tag;
import pe.edu.upc.RsOperation.mappers.TagMapper;
import pe.edu.upc.RsOperation.repositories.TagDao;

import java.util.List;

@Repository
public class MybatisTagDao implements TagDao {
    @Autowired
    TagMapper tagMapper;


    @Override
    public List<Tag> listTag() throws Exception {
        return tagMapper.listTag();
    }
    @Override
    public Tag getTag(Tag tag) throws Exception {
        return tagMapper.getTag(tag);
    }
}
