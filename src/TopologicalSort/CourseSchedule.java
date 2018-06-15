package TopologicalSort;

//题目描述:
//解法描述:拓扑排序，统计节点的入度，每次找到入度为0的节点，这就是拓扑的顺序
public class CourseSchedule {

    private int findZeroIndegree(int[] indegree) {
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        // 统计每个节点的入度
        for (int i = 0; i < prerequisites.length; ++i) {
            ++indegree[prerequisites[i][0]];
        }

        for (int i = 0; i < numCourses; ++i) {
            int index = findZeroIndegree(indegree);
            // 说明有环
            if (index == -1) {
                return false;
            }
            // 删除节点 更新节点的入度
            indegree[index] = -1;
            for (int j = 0; j < prerequisites.length; ++j) {
                if (prerequisites[j][1] == index) {
                    --indegree[prerequisites[j][0]];
                }
            }
        }


        return true;
    }
}
