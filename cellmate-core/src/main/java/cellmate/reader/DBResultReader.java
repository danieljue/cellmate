package cellmate.reader;

import cellmate.cell.CellGroup;
import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;

/**
 * User: bfemiano
 * Date: 8/27/12
 * Time: 12:15 AM
 */
@Beta
public interface DBResultReader<D, C> {

    public ImmutableList<CellGroup<C>> read(Iterable<D> dbItems, ReadParameters parameters);

    public ImmutableList<CellGroup<C>> read(Iterable<D> dbItems,
                                            ReadParameters parameters,
                                            CellTransformer<D,C> transformer);
}
