package baseball.presenter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.core.BaseballGame;
import baseball.io.MenuConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTest {

    Menu sut;

    MenuConsole console = mock(MenuConsole.class);
    GameFinder gameFinder = mock(GameFinder.class);

    @BeforeEach
    void setUp() {
        BaseballGame game = mock(BaseballGame.class);
        given(gameFinder.findBy(1)).willReturn(game);
        sut = Menu.of(console, gameFinder);
    }

    @Test
    void 사용자가_1을_입력하면_계속한다() {
        given(console.queryStartGame()).willReturn(1);

        boolean loop = sut.loop();

        assertThat(loop).isTrue();
    }

    @Test
    void 사용자가_2를_입력하면_종료된다() {
        given(console.queryStartGame()).willReturn(2);

        boolean loop = sut.loop();

        assertThat(loop).isFalse();
    }

    @Test
    void 사용자가_3을_입력하면_예외를_던진다() {
        given(console.queryStartGame()).willReturn(3);

        assertThatThrownBy(() -> sut.loop())
                .isInstanceOf(IllegalArgumentException.class);
    }
}