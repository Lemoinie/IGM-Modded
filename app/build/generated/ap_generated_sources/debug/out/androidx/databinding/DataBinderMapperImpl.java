package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new it.paranoidsquirrels.idleguildmaster.DataBinderMapperImpl());
  }
}
