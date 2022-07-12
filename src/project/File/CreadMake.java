package project.File;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ezequeil
 */
public class CreadMake {
    
    public static  String MAKE = "SRCS = $files \n" +
        "\n" +
        "CC = clang++\n" +
        "NAME = $folder\n" +
        "\n" +
        "CFLANG = -Wall -Wextra -Werror -std=c++98\n" +
        "OBJS = $(SRCS:.cpp=.o)\n" +
        " \n" +
        "\n" +
        "all: $(NAME)\n" +
        "\n" +
        "$(NAME): $(OBJS)\n" +
        "	$(CC) $(CFLAG) -o $(NAME) $(OBJS)\n" +
        "\n" +
        "clean:\n" +
        "	rm -f $(OBJS)\n" +
        "\n" +
        "fclean: clean\n" +
        "	rm -f $(NAME)\n" +
        "\n" +
        "re: fclean all\n" +
        "\n" +
        "m: fclean\n" +
        "\n" +
        "r: \n" +
        "	make re && clear && ./$(NAME)\n" +
        "\n" +
        ".PHONY: all clean fclean re";
    
    public static String getText(String folder, ArrayList<String> files)
    {
        String new_make;
        String file_names = "";
        String temp;
        
        for (int i = 0; i < files.size(); i++)
        {
            temp = files.get(i);
            if (temp.contains(".cpp") && !temp.contains("*"))
            {
                if (file_names == null)
                    file_names = temp;
                else
                    file_names += " \\ \n" + temp;
            }
                
        }
        new_make = MAKE.replace("$files", file_names);
        new_make = new_make.replace("$folder", folder);
        return (new_make);
    }
}
