package BitManipulation;

public class BitNotes {
}

/*
https://www.youtube.com/watch?v=JqxgC5zcdEw
=> Converting a 2D array to 1D

       0  1
    0 [7, 3]
    1 [4, 6]

    index = (row * ROW_LENGTH) + col
        0 = (0 * 2) + 0
        1 = (0 * 2) + 1
        2 = (1 * 2) + 0
        3 = (1 * 2) + 1

     0  1  2  3
    [7, 3, 4, 6]

=>  Log2(2,000,000,000) is almost 27,
    2^32 is more than 2,000,000,000 ! (basic math)
    i.e Log2(2 ^ n) = n

*/