library(ggplot2)
library(ggthemes)
library(extrafont)
library(plyr)
library(scales)
charts.data <- read.csv("/Users/guoyifeng/Downloads/R scripts/balance.csv")
p <- ggplot() + geom_bar(aes(y=Percentage,x = Activity, fill = DataType), data = charts.data,
                         stat = "identity") + coord_flip()
p <- p + geom_text(data = charts.data, aes(x = Activity, y = Percentage, label = paste0(Percentage,"%")), size = 4)

p
