package com.example.filmcatalog.viewmodel

import androidx.lifecycle.ViewModel
import com.example.filmcatalog.R
import com.example.filmcatalog.data.Film

class FilmsViewModel : ViewModel() {
    val filmList: List<Film>
        get() = _filmList
    private val _filmList = listOf<Film>(
        Film(
            0, "Гнев человеческий", R.drawable.film_img_0, "23.04.2022", 3.5,
            "Эйч — загадочный и холодный на вид джентльмен, но внутри него пылает жажда справедливости. " +
                    "Преследуя свои мотивы, он внедряется в инкассаторскую компанию, чтобы выйти на соучастников " +
                    "серии многомиллионных ограблений, потрясших Лос-Анджелес. В этой запутанной игре у каждого " +
                    "своя роль, но под подозрением оказываются все. Виновных же обязательно постигнет гнев человеческий."
        ),
        Film(
            1, "Мортал Комбат", R.drawable.film_img_1, "12.07.2022", 5.0,
            "Боец смешанных единоборств Коул Янг не раз соглашался проиграть за деньги. " +
                    "Он не знает о своем наследии и почему император Внешнего мира Шан Цзун посылает " +
                    "могущественного криомансера Саб-Зиро на охоту за Коулом. Янг боится за безопасность своей семьи, " +
                    "и майор спецназа Джакс, обладатель такой же отметки в виде дракона, как и у Коула, " +
                    "советует ему отправиться на поиски Сони Блейд."
        ),
        Film(
            2, "Упс...Приплыли", R.drawable.film_img_2, "05.09.2022", 3.0,
            "От Великого потопа зверей спас ковчег. Но спустя полгода скитаний они готовы сбежать с него куда угодно. " +
                    "Нервы на пределе. Хищники готовы забыть про запреты и заглядываются на травоядных. Единственное спасение — " +
                    "найти райский остров. Там простор и полно еды. Но даже если он совсем близко, будут ли рады местные такому " +
                    "количеству гостей?"
        ),
        Film(
            3, "The Box", R.drawable.film_img_3, "01.03.2022", 4.5,
            "Уличный музыкант знакомится с музыкальным продюсером, и они вдвоём отправляются в путешествие, которое перевернёт их жизни."
        ),
        Film(
            4, "Сага о Дэни Эрнандас", R.drawable.film_img_4, "02.07.2022", 4.0,
            "Tekashi69 или Сикснайн — знаменитый бруклинский рэпер с радужными волосами — прогремел синглом «Gummo», " +
                    "коллабом с Ники Минаж, а также многочисленными преступлениями. В документальном расследовании о жизни и творчестве" +
                    " рэпера разворачивается настоящая гангстерская история, в которой количество обвинений растет пропорционально интернет-популярности, " +
                    "а репутация секс-наркомана получает свое подтверждение не только в скандальных видео музыканта. Похоже, это последний " +
                    "антигерой нашего времени, которого не коснулась культура отмены: у Tekashi69 24 млн. подписчиков в Instagram, миллиарды " +
                    "просмотров на Youtube и несколько судимостей."
        ),
        Film(
            5, "Пчелка Майя", R.drawable.film_img_5, "30.04.2022", 5.0,
            "Когда упрямая пчелка Майя и ее лучший друг Вилли спасают принцессу-муравьишку, начинается сказочное и " +
                    "опасное приключение, которое приведет их в необычные новые миры и проверит их дружбу на прочность."
        ),
    )
    fun getFilmById(id: Int) = filmList[id]
}