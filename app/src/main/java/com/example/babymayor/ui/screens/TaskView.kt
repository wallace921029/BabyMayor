package com.example.babymayor.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.babymayor.data.model.Task
import com.example.babymayor.ui.components.PriorityFlag
import com.example.babymayor.ui.components.SwipeableItem

@Composable
fun TaskView() {
    val taskList = listOf(
        Task(
            id = 1,
            taskTitle = "完成报告",
            taskNote = "需要尽快完成",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 2,
            taskTitle = "参加会议",
            taskNote = "优先级较高",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 3,
            taskTitle = "进行代码审查",
            taskNote = "详细检查",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 4,
            taskTitle = "更新文档",
            taskNote = "与团队分享",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 5,
            taskTitle = "设计新功能",
            taskNote = "待确认",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 6,
            taskTitle = "修复漏洞",
            taskNote = "需要讨论",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 7,
            taskTitle = "优化性能",
            taskNote = "简单任务",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 8,
            taskTitle = "编写测试用例",
            taskNote = "注意细节",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 9,
            taskTitle = "整理数据",
            taskNote = "需要反馈",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 10,
            taskTitle = "撰写博客",
            taskNote = "持续跟进",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 11,
            taskTitle = "学习新技术",
            taskNote = "需要更新",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 12,
            taskTitle = "进行用户调研",
            taskNote = "保持关注",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 13,
            taskTitle = "制定计划",
            taskNote = "定期检查",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 14,
            taskTitle = "团队协作",
            taskNote = "记录问题",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 15,
            taskTitle = "客户沟通",
            taskNote = "收集信息",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 16,
            taskTitle = "准备演示",
            taskNote = "准备材料",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 17,
            taskTitle = "回顾项目",
            taskNote = "研究解决方案",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 18,
            taskTitle = "分析需求",
            taskNote = "测试不同方案",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 19,
            taskTitle = "开发工具",
            taskNote = "提高效率",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 20,
            taskTitle = "创建模板",
            taskNote = "注意安全",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 21,
            taskTitle = "配置环境",
            taskNote = "保持联系",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 22,
            taskTitle = "培训新人",
            taskNote = "及时汇报",
            taskPriority = 2,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 23,
            taskTitle = "记录笔记",
            taskNote = "主动沟通",
            taskPriority = 3,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 24,
            taskTitle = "阅读文档",
            taskNote = "总结经验",
            taskPriority = 4,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        ),
        Task(
            id = 25,
            taskTitle = "改善流程",
            taskNote = "改进方法",
            taskPriority = 1,
            taskExpiredDatetime = "2025-10-29 23:12:12"
        )
    )

    // 页面布局
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "# Today",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.padding(top = 10.dp))
        Box(
            modifier = Modifier
                .shadow(elevation = 20.dp, RoundedCornerShape(10.dp), spotColor = Color.LightGray)
                .clip(RoundedCornerShape(10.dp))
        ) {
            LazyColumn {
                itemsIndexed(taskList.slice(0..4)) { _, task ->
                    ListItem(
                        modifier = Modifier
                            .drawWithContent {
                                drawContent()
                                drawLine(
                                    color = Color.LightGray,
                                    strokeWidth = 1.dp.toPx(),
                                    start = Offset(0f, size.height + 1),
                                    end = Offset(size.width, size.height + 1)
                                )
                            },
                        headlineContent = {
                            Text(text = task.taskTitle)
                        },
                        supportingContent = {
                            Text(text = task.taskNote)
                        },
                        leadingContent = {
                            PriorityFlag(task.taskPriority)
                        },
                        trailingContent = {
                            Text(text = task.taskExpiredDatetime.slice(11 until task.taskExpiredDatetime.length))
                        }
                    )
                }
            }
        }

        SwipeableItem()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskView() {
    TaskView()
}