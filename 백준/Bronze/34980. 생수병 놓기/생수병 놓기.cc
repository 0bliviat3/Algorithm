#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    int n;
    std::cin >> n;
    
    std::string line1, line2;
	std::cin >> line1 >> line2;

    if (line1 == line2) {
        std::cout << "Good";
        return;
    }

	int cnt = 0, differCnt = 0;
    for (int i = 0; i < n; i++) {
        if (line1[i] == 'w') {
            cnt++;
        }
        if (line2[i] == 'w') {
            differCnt++;
		}
    }

    if (cnt == differCnt) {
        std::cout << "Its fine";
    } else if (cnt < differCnt) {
        std::cout << "Manners maketh man";
    } else {
        std::cout << "Oryang";
	}



}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}