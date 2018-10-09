
package converters;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import repositories.ShoutRepository;
import domain.Shout;

@Component
@Transactional
public class StringToShout extends StringToGeneric<Shout, ShoutRepository> {

}
