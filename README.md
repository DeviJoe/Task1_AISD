# TextProcessor
Task 1-12 (A&amp;SD)

    Объектное представление текстового документа (секции, списки) с форматированием
    Классы - Параграф, Стиль и Документ.
    У Стиля свойтва: отступы сверху, снизу, слева, справа, красная строка (измеряется в кол-ве строк или символов),
    выравнивание (влево/вправо/по центру/по ширине), признак списка (с номером или с маркером).
    Параграф наследуется от стиля, а также может иметь стиль (собственные параметры параграфа перекрывают параметры стиля).
    Кроме того, для параграфа может быть задан номер, с которого начинается нумерация.
    Документ - состоит из параграфов и может печатать/сохранять форматированный документ в текстовом виде.
