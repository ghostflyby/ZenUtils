package youyihj.zenutils.impl.util;

import net.minecraft.stats.IStatType;
import youyihj.zenutils.api.player.DefaultStatFormatters;
import youyihj.zenutils.api.player.IStatFormatter;

/**
 * @author youyihj
 */
public interface IStatFormatterAdapter {
    IStatFormatter adapt(IStatType type);

    class Client implements IStatFormatterAdapter {

        @Override
        public IStatFormatter adapt(IStatType type) {
            return new PresentTypeFormatter(type::format, type);
        }
    }

    class Server implements IStatFormatterAdapter {

        @Override
        public IStatFormatter adapt(IStatType type) {
            return new PresentTypeFormatter(DefaultStatFormatters.simple(), type);
        }
    }

    class PresentTypeFormatter implements IStatFormatter {
        private final IStatFormatter parent;
        private final IStatType type;

        public PresentTypeFormatter(IStatFormatter parent, IStatType type) {
            this.parent = parent;
            this.type = type;
        }

        @Override
        public String format(int number) {
            return parent.format(number);
        }

        @Override
        public IStatType toType() {
            return type;
        }
    }
}
