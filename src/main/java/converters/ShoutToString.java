
package converters;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import domain.Shout;

@Component
@Transactional
public class ShoutToString extends GenericToString<Shout> {

}
