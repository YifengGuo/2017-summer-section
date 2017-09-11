library(ggplot2)

dt <- data.frame(Activity = factor(x = rep(x = c(1:8), times = 2), 
                                   labels = c("Airway-Stated","Breath-Sounds","Distal-Pulses","GCS-Stated","Pupil-Exam","Temperature","Warm-Blanket","Central-Pulses")), 
                 DataType = factor(x = rep(x = c(1:2), each = 8),
                                   labels = c("Origin", "Generated")), 
                 Prc = c(13,14,13,14,14,14,14,4,13,14,13,14,14,14,14,4), 
                 label = c("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0")) 

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


library(gtable)

fontsize = 8.8
gp = gpar(fontsize = fontsize, col = "grey10")
textGrobF = textGrob("Origin", x = .75, gp = gp)
textGrobM =  textGrob("Generated", x = .25, gp = gp)

strip = gTree(name = "Strip", 
              vp = viewport(y = 1, just = "bottom", height = unit(2.5, "grobheight", textGrobF)),
              children = gList(
                rectGrob(gp = gpar(col = NA, fill = "grey85")),
                textGrobF, 
                textGrobM,                                         
                linesGrob(x = .5, gp = gpar(col = "grey95"))))

g = ggplotGrob(p)

# Position strip using the gtable function, gtable_add_grob
# Strip is positioned in the plot panel,
# but because of the justification of strip's viewport,
# the strip is drawn outside the panel

# First, get the panel's position in the layout
pos = g$layout[grepl("panel", g$layout$name), c("t","l")]

g = gtable_add_grob(g, strip, t = pos$t, l = pos$l, clip = "off")

grid.newpage()
grid.draw(g)

