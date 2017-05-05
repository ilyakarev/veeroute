state: Offtopic

    state: NoMatch, noChangeState = true
        q: *, fromState = /
        if: parseTree.text == sessionData.lastCatchAll
            a: Да, Вы уже писали.
            a: Да, я прочитала.
        else: 
            script: 
                sessionData.lastCatchAll = parseTree.text
            a: Простите, не поняла.
            a: Не совсем понимаю.
            a: Извините, я не поняла.
            a: Прошу прощения, не поняла Вас. 

    state: Offtopic, noChangeState = true
        state: NewState
            q: Жесткий ржачь
            q: Тупой ржачь
            a: Ответ
            
        state: Как Вас зовут, noChangeState = true
            q: * мо* [я] $you * (называть|звать) * ?, fromState = /
            q: * мо* [я] * (называть|звать) $you * ?, fromState = /
            q: * как* [у] ($you|твоя|ваша) фамилия * ?, fromState = /
            q: * фамилия (как* твоя|какая у тебя|какая у вас|твоя|ваша) * ?, fromState = /
            q: * а фамилия какая ?, fromState = /
            q: * {(как*|назови*) [мне] * ($you|твоё|твое|своё|свое) * (зовут|звать|завут|имя|называть|обращат*|обращя*|обращац*)} * ?, fromState = /
            q: кто (будешь|будете) ?, fromState = /
            q: * как* * $you * себя * называе* * ?, fromState = /
            q: [а] {как зовут} ?, fromState = /
            q: * {(тебя|тво*|вас|ваше) * (отчество|имя)} * ?, fromState = /
            q: * {как* * отчество} * ?, fromState = /
            a: Меня зовут Марфа.
            a: Я Марфа, сотрудница магазина M:Retail

        state: Из какого Вы города, noChangeState = true
            q: {откуда $you} такая * ?, fromState = /
            q: * $you * из россии ?, fromState = /
            q: * $you * из какой страны * ?, fromState = /
            q: * в какой стране * (живешь|живёшь|живете|живёте) * ?, fromState = /
            q: * {(в каком город*|где|откуда|место) * [$you] * (родил*|жив*|родом|обитае*|рождения)} * ?, fromState = /
            q: * (откуда|от куда) * [$you] * (будешь|будете|родом) ?, fromState = /
            q: где (твой|ваш) дом ?, fromState = /
            q: * $you (откуда|от куда|в каком город*) ?, fromState = /
            q: * (из|с|в) как* * $you город* * ?, fromState = /
            q: * (откуда|от куда|в каком город*) * $you ?, fromState = /
            q: * $you (из|с) какого города * ?, fromState = /
            q: * [и] {где $you} [сейчас|щас] [находи*] ?, fromState = /
            q: город ?, fromState = /
            a: Я из Санкт-Петербурга.

        state: Дура, noChangeState = true
            q: * [$you] [тупая|глуп*] [жирная] (дура|овца|коза|обезьяна|ты животное|корова|скотина) * !, fromState = /
            q: оближи мо* *, fromState = /
            q: * [$you] * (жоп*|попа|попу|попк*|зад|задниц*|анус|пизда|пизд*|письк*|хуйня|блять|какашка|влагалище|манда|член|блин|говно|пенис|залупа|сперма|какашки|бля) * !, fromState = /
            q: * [$you] * (сука|проститутка|сучка|шлюха|шалава|ебанутая|тварь|блядь|стерва|шлюшка|хуесоска|ебанашка|пидараска) * !, fromState = /
            a: Пожалуйста, не ругайтесь.

        state: Кто тебя сделал, noChangeState = true
            q: * [а] кто * (тебя|вас) * (созда*|сделал|разработал*|написал) * ?, fromState = /
            q: * кто * (тво*|ваш*|тебя|вас) * (автор*|созда*|сделал|разработал*|родител*|придумал*) * ?, fromState = /
            q: * кто * (автор*|созда*|твор*|сотвор*) * (тво*|ваш*|тебя|вас) * ?, fromState = /
            a: Меня сделали в ходе хакатона AngelHack в Санкт-Петербурге. Сайт нашего проекта - http://saleshack.ru


    state: HelloBye, noChangeState = true

        state: Здравствуйте, noChangeState = true
            q: {(утро|день|вечер) (добрый|доброе)}, fromState = /
            q: давн* не виделись !, fromState = /
            q: * (привет|привеет|приивеет|приветик|приветики|при вед|здравствуй|здравствуй*|здрасьте|хэй|хай|хэллоу|халоу|здаров|шалом|hello|здарова|хелло|здаровеньки|здоровеньки|здрасте|салют|hi|приветствую|доброго времени суток|хеллоу|п р и в е т|здраствуй*) *, fromState = /
            a: Здравствуйте.
            a: Чем могу помочь?
            a: Здравствуйте.\nМогу я чем-нибудь помочь?

        state: До свидания, noChangeState = true
            q: * спокой* ночи * !, fromState = /
            q: * [ладно|все|давай|ну] (пока|до свидан*|до встречи|до завтра|до связи|конец связи|досвидани*|досвидос|дозавтра|прощай|бай бай|гудбай|чау|чао|чмоки чмоки|пока-пока|п о к а) *, fromState = /
            q: (увидимся|счастливо|удачи|бывай) !, fromState = /
            a: Всего доброго.
            a: Всего хорошего.

    state: CustomNoMatch, noChangeState = true
        state: тест, noChangeState = true
            q: (11|тест|прием|есть контакт|проверка связи) [прием], fromState = /
            a: Связь в порядке.\nСлушаю Вас внимательно.

        state: Фывфыв аываыапф, noChangeState = true
            q: * (ъ*|ы*|ь*|*ъ) *, fromState = /
            q: * (аа*|ввв*|гг*|дд*|ее*|зз*|ии*|кк*|лл*|мм*|нн*|оо*|пп*|рр*|ссс*|тт*|уу*|фф*|хх*|шш*|щщ*|чч*|цц*|юю*|яяя*|ь*|ъ*|ыы*) *, fromState = /
            q: * (фыва*|*фыва|*ееее|*аае|аач*|*аащ|аащ*|ааы*|*ааы|*ааъ|*ааь|*ааэ|ааь*|ааъ*|абг*|*абг|*абд|абп*|*абп|абф*|*абф|абц*|*абц|абч*|*абч|абш*|*абш|абщ*|*абщ|абэ*|*абэ|*абю|*абх|авф*|*авф|авц*|*авц|*авч|*авщ|*авш|авэ*|*авэ|*авб|*авг|*авж|*авп|*агб|агб*|*агж|*агн|агп*|*агп|агф*|*агф|агц*|*агц|агч*|*агч|агш*|*агш|агщ*|*агщ|агэ*|*адб|адб*|адг*|*адг|*адк|адк*|адп*|*адп|адф*|*адф|адц*|адц*|адч*|*адч|адш*|*адш|адщ*|*адщ|адэ*|*адэ|аеа*|*аеа|аеэ*|*аеэ|аею*|*ажл|*ажв|*ажг|*ажд|ажз*|*ажз|*ажн|ажп*|*ажп|ажс*|*ажс|ажт*|*ажт|ажф*|*ажф|ажх*|*ажх|ажц*|*ажц|ажч*|*ажч|ажш*|*ажш|ажщ*|*ажщ|ажы*|*ажы|ажь*|*ажь|ажъ*|*ажъ|ажэ*|*ажэ|*ажю|*ажя|ажя*|азс*|*азс|азф*|*азф|азц*|*азц|азч*|*азч|азш*|*азш|азщ*|*азщ|азэ*|*азэ|азъ*|*азъ|азт*|аиэ*|*аиэ|*айб|айг*|*айг|айд*|айж*|*айж|айз*|*айз|айй*|*айй|айк*|*айк|айл*|*айл|айм*|айн*|айп*|*айс|айр*|айт*|айу*|*айу|айф*|айх*|айц*|*айц|айч*|*айч|айш*|*айш|айщ*|*айщ|айь*|*айь|айъ*|*айъ|айы*|*айы|айэ*|*айэ|айю*|*айю|айя*|акб*|*акб|акж*|*акж|акп*|*акп|акф*|*акф|акщ*|*акщ|алж*|*алж|алн*|*алн|алф*|*алф|алц*|*алц|алч*|*алч|алщ*|*алщ|алъ*|*алъ|алэ*|*алэ|*амф|*амц|амч*|*амч|*амш|амщ*|*амщ|амэ*|*амэ|*амб|амг*|*амг|амж*|*амж|*анф|анц*|*анц|аоэ*|*аоэ|апб*|*апб|апг*|*апг|апж*|*апж|апф*|*апф|апц*|*апц|*апч|*апш|апщ*|*апщ|апэ*|*апэ|*арж|арл*|арц*|арч*|*арч|*арш|арщ*|*арщ|арэ*|*арэ|*асг|асщ*|*асщ|*асш|*асч|*асц|атф*|*атф|атц*|*атц|атш*|*атш|*атщ|атб*|*атб|атг*|*атг|атж*|*атж|атз*|*атз|атп*|*атп|*ауф|ауь*|*ауь|ауъ*|*ауъ|ауэ*|*ауэ|аую*|ауя*|*ауя|афс*|*афс|афц*|*афц|афч*|*афч|афш*|*афш|афщ*|*афщ|*афы|афь*|*афь|афъ*|*афъ|афэ*|*афэ|афю*|*афю|афя*|*афя|ахб*|*ахб|ахг*|*ахг|ахд*|*ахд|ахж*|*ахж|ахз*|*ахз|ахй*|*ахй|ахк*|*ахк|ахм*|*ахм|*ахн|ахп*|*ахп|ахт*|ахф*|*ахф|ахц*|*ахц|ахч*|*ахч|ахш*|*ахш|ахщ*|*ахщ|ахы*|*ахы|ахь*|*ахь|ахъ*|*ахъ|ахэ*|*ахэ|ахю*|*ахю|ахя*|*ахя|*ацт|ацу*|ацф*|*ацф|ацх*|*ацх|ацч*|*ацч|ацш*|*ацш|ацщ*|*ацщ|аць*|*аць|ацъ*|*ацъ|ацэ*|*ацэ|ацю*|*ацю|аця*|*аця|ацб*|*ацб|ацг*|*ацг|ацж*|*ацж|ацз*|*ацз|ацл*|*ацл|ацм*|*ацм|ацп*|*ацп|ачб*|*ачб|ачг*|*ачг|ачж*|*ачж|ачз*|*ачз|ачк*|*ачк|ачп*|*ачп|ачф*|*ачф|ачц*|*ачц|ачш*|*ачш|ачщ*|*ачщ|ачэ*|*ачэ|ачю*|*ачю|ачя*|*ачя|ашф*|*ашф|*ашх|ашц*|*ашц|ашщ*|*ашщ|ашы*|*ашы|ашь*|ашъ*|*ашъ|ашэ*|*ашэ|ашю*|*ашю|ашя*|*ашя|ашб*|*ашб|ашг*|*ашг|ашж*|*ашж|ашз*|*ашз|*ашк|*ашл|ашм*|*ашм|*ашн|*ашп|ащб*|*ащб|ащв*|*ащв|ащг*|*ащг|ащд*|*ащд|ащж*|*ащж|ащз*|*ащз|ащй*|*ащй|ащк*|*ащк|ащл*|*ащл|ащм*|*ащм|ащн*|*ащн|ащп*|*ащп|ащр*|*ащр|ащс*|*ащс|ащт*|*ащт|ащф*|*ащф|ащх*|*ащх|ащц*|*ащц|ащч*|*ащч|ащш*|*ащш|ащы*|*ащы|ащь*|ащъ*|*ащъ|ащэ*|*ащэ|ащю*|*ащю|ащя*|*ащя|аы*|*аыа|*аыз|*аыи|*аыо|*аып|*аыа|*аыд|*аыз|*аыи|*аыо|*аыу|*аыф|*аыц|*аыь|*аыъ|*аыэ|*аыю|*аыя|аь*|*аьу|*аьф|*аьх|*аьц|*аьщ|*аьы|*аьъ|*аьэ|*аьа|*аьб|*аьв|*аьг|*аьж|*аьз|*аьй|*аьк|*аьо|*аьп|аъ*|*аэб|*аэг|аэе*|*аэе|аэж*|*аэж|*аэз|*аэл|*аэн|*аэо|*аэп|*аэр|*аэт|*аэу|*аэф|*аэц|*аэч|*аэш|аэш*|*аэщ|аэщ*|аэы*|*аэы|аэь*|*аэь|аэъ*|*аэъ|аэю*|*аэю|*аэя|аюа*|*аюа|*аюв|*аюд|аюе*|*аюе|аюи*|*аюл|*аюм|*аюо|аюо*|аюп*|аюс*|ают*|аюу*|*аюу|аюх*|аюц*|*аюц|аюч*|ающ*|*ающ|аюы*|*аюы|аюь*|*аюь|аюъ*|*аюъ|аюэ*|*аюэ|аюя*|аяф*|*аяф|аяц*|аяы*|*аяы|аяь*|*аяь|аяъ*|*аяъ|аяэ*|*аяэ|аяю*|*аяб|аяа*|*аяа|*аяв|*аяе|аяе*|аяж*|аяи*|*аяи|аяо*|*аяо) *, fromState = /
            a: Вы, наверное, опечатались.

