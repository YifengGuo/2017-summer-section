library(ggplot2)

dt <- data.frame(Activity = factor(x = rep(x = c(1:8), times = 2), 
                                 labels = c("Airway-Stated","Breath-Sounds","Distal-Pulses","GCS-Stated","Pupil-Exam","Temperature","Warm-Blanket","Central-Pulses")), 
                 DataType = factor(x = rep(x = c(1:2), each = 8),
                                 labels = c("Origin", "Generated")), 
                 Prc = c(13,14,13,14,14,14,14,4,13,14,13,14,14,14,14,4), 
                 label = c("13","14","13","14","14","14","14","4","13","14","13","14","14","14","14","4")) 

xmi <- -100
xma <- 100

p = ggplot(data = dt, aes(x = Activity, fill = DataType)) +
  geom_bar(stat = "identity", data = subset(dt, DataType == "Origin"), aes(y = Prc)) +
  geom_text(data = subset(dt, DataType == "Origin"), aes(y = Prc, label = label), 
            size = 4, hjust = -0.1) +
  geom_bar(stat = "identity", data = subset(dt, DataType == "Generated"), aes(y=Prc * (-1)) ) +
  geom_text(data = subset(dt, DataType == "Generated"), aes(y = Prc * (-1), label = label), 
            size = 4, hjust = 1.1) +
  scale_y_continuous(limits = c(xmi, xma), breaks = seq(xmi, xma, 10), labels = abs(seq(xmi, xma, 10))) + 
  theme(axis.text = element_text(colour = "black")) + 
  coord_flip() + 
  ylab("") + xlab("") + guides(fill = FALSE) +
  theme(plot.margin = unit(c(2, 1, 1, 1), "lines"))


## Method 1
# Construct the strip
library(grid)

strip = gTree(name = "Strip", 
              children = gList(
                rectGrob(gp = gpar(col = NA, fill = "grey85")),
                textGrob("Orgin", x = .75, gp = gpar(fontsize = 8.8, col = "grey10")), 
                textGrob("Genreated", x = .25, gp = gpar(fontsize = 8.8, col = "grey10")),
                linesGrob(x = .5, gp = gpar(col = "grey95"))))

# Position strip using annotation_custom
p1 = p + annotation_custom(strip, xmin = Inf, xmax = 3.75, ymax = Inf, ymin = -Inf) 

g = ggplotGrob(p)

# The strip is positioned outside the panel,
# therefore turn off clipping to the panel.
g$layout[g$layout$name=='panel', "clip"] = "off"

# Draw it
grid.newpage()
grid.draw(g)

